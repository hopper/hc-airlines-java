package com.hopper.cloud.airlines;

import com.google.gson.Gson;
import com.hopper.cloud.airlines.model.BookingConfirmed;
import com.hopper.cloud.airlines.model.Channel;
import com.hopper.cloud.airlines.model.CreateAirlineCfarSessionRequest;
import com.hopper.cloud.airlines.model.WhiteLabel;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Smoke tests guarding the 2.0 changes that the compiler can't catch:
 *  - the new booking_confirmed offer-id fields round-trip through gson, and
 *  - the new (manually-wired in {@link JSON}) Channel discriminated type serializes
 *    correctly on a session request.
 */
public class SerializationTest {

    private final Gson gson = JSON.getGson();

    @Test
    public void bookingConfirmedRoundTripsWithOfferIds() {
        BookingConfirmed original = new BookingConfirmed()
                .type(BookingConfirmed.TypeEnum.BOOKING_CONFIRMED)
                .occurredDateTime(OffsetDateTime.of(2026, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC))
                .cfarOfferIds(Arrays.asList("cfar-1", "cfar-2"))
                .dgOfferIds(Arrays.asList("dg-1"))
                .putBookingReferencesItem("cfar", "PNR123");

        String json = gson.toJson(original);
        assertTrue("expected cfar_offer_ids in JSON: " + json, json.contains("cfar_offer_ids"));
        assertTrue("expected dg_offer_ids in JSON: " + json, json.contains("dg_offer_ids"));
        assertTrue("expected booking_references in JSON: " + json, json.contains("booking_references"));

        BookingConfirmed parsed = gson.fromJson(json, BookingConfirmed.class);
        assertEquals(BookingConfirmed.TypeEnum.BOOKING_CONFIRMED, parsed.getType());
        assertEquals(Arrays.asList("cfar-1", "cfar-2"), parsed.getCfarOfferIds());
        assertEquals(Arrays.asList("dg-1"), parsed.getDgOfferIds());
        assertEquals("PNR123", parsed.getBookingReferences().get("cfar"));
    }

    @Test
    public void channelSerializesWithDiscriminatorOnSessionRequest() {
        WhiteLabel whiteLabel = new WhiteLabel()
                .brand("AcmeAir")
                .type(WhiteLabel.TypeEnum.WHITE_LABEL);
        CreateAirlineCfarSessionRequest request = new CreateAirlineCfarSessionRequest();
        request.setChannel(new Channel(whiteLabel));

        // `channel` is an outbound request field (the client sends it; it is never
        // parsed from a response), so serialization is the meaningful guard here.
        // It exercises the manually-wired Channel.CustomTypeAdapterFactory in JSON.
        String json = gson.toJson(request);
        assertTrue("expected white_label discriminator in JSON: " + json, json.contains("white_label"));
        assertTrue("expected brand in JSON: " + json, json.contains("AcmeAir"));
    }
}
