# Changelog

## 2.0.0

Resyncs the SDK with the live Airline API (`airline/v1.1`) after a long period of
drift. This is a **breaking** release.

### Breaking changes

- **Discriminator `type` fields are now enums.** Across all discriminated models
  (events, form-of-payment, browser/OS/platform/device, etc.) the `type` field changed
  from `String` to a generated nested `TypeEnum`. `getType()`/`setType(...)`/the `type(...)`
  builder now use the enum.

  ```java
  // Before (1.x)
  new BookingConfirmed().type("booking_confirmed");
  if ("booking_confirmed".equals(event.getType())) { ... }

  // After (2.0)
  new BookingConfirmed().type(BookingConfirmed.TypeEnum.BOOKING_CONFIRMED);
  if (BookingConfirmed.TypeEnum.BOOKING_CONFIRMED == event.getType()) { ... }
  ```

- **`postEvents` (`POST /events`): `HC-Session-ID` is now optional, and the parameter
  order changed** to `postEvents(Event event, String hcSessionID)` (required body first,
  optional header last). Pass `null` for the session on `booking_confirmed` events that
  link back via offer IDs.

- **Removed endpoints** (already removed from the API):
  - `postCustomerEvents` (`POST /customer/events`)
  - `postCustomerDgEvents` (`POST /customer/dg/events`)
  - `putCfarContractsIdPassengerInfo` (`PUT /cfar_contracts/{id}/passenger_info`)

- **`DgPassenger.dateOfBirth` is now a `String`** (e.g. `"2015-06-06"`) instead of a date.

### Added

- **`booking_confirmed`: `cfarOfferIds` and `dgOfferIds`** (`List<String>`) — link a
  booking-confirmed event back to its session via offer IDs when no `HC-Session-ID`
  header is sent.
- **`booking_confirmed`: `bookingReferences`** (`Map<String, String>`) — partner booking
  references captured on the booking-confirmed event.
- **Distribution `channel`** — a new discriminated type (`agent_reseller`, `api`,
  `direct`, `online_booking_tool`, `white_label`), available as an optional field on
  `CreateAirlineCfarSessionRequest` and `CreateAirlineDgSessionRequest`.
- **New endpoints:** `getCustomerCfarPayoutReceipt` (`GET /customer/cfar/payout/receipt`),
  `getCustomerDgPayoutReceipt` (`GET /customer/dg/payout/receipt`),
  `getCustomerDgExercisesIdSession` (`GET /customer/dg_exercises/{id}/session`),
  `postCfarOffersExternal` (`POST /cfar_offers/external`).
- New models: `GetDgExerciseSessionResponse`, `CreateExternalCfarOfferRequest`.

### Internal

- Client-side JSON validation (`validateJsonElement`) removal is now codified in
  `scripts/strip_validation.py` and runs as part of `generate.sh`, so the client stays
  tolerant of unknown/extra fields across regenerations. See `REGENERATING.md`.
- Note: model classes for the removed customer-event endpoints (`CfarEvent`, `DgEvent`,
  and their event sub-types) remain in the package as unused dead code; a dedicated
  cleanup is tracked as a follow-up.
