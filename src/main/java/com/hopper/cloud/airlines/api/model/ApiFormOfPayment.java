package com.hopper.cloud.airlines.api.model;

import com.hopper.cloud.airlines.model.FormOfPaymentType;

import java.util.Currency;
import java.util.Objects;

public abstract class ApiFormOfPayment {
    protected String amount;
    protected FormOfPaymentType type;

    protected ApiFormOfPayment(String amount, FormOfPaymentType type) {
        this.amount = amount;
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public static class PaymentCard extends ApiFormOfPayment {
        private final Currency currency;
        private final String token;

        public PaymentCard(String amount, Currency currency, String token) {
            super(amount, FormOfPaymentType.PAYMENT_CARD);
            this.currency = currency;
            this.token = token;
        }

        public Currency getCurrency() {
            return currency;
        }

        public String getToken() {
            return token;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PaymentCard fop = (PaymentCard) o;
            return Objects.equals(this.amount, fop.amount) &&
                    Objects.equals(this.type, fop.type) &&
                    Objects.equals(this.currency, fop.currency) &&
                    Objects.equals(this.token, fop.token);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, type, currency, token);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class PaymentCard {\n");
            sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
            sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
            sb.append("    token: ").append(toIndentedString(token)).append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Points extends ApiFormOfPayment {
        public Points(String amount) {
            super(amount, FormOfPaymentType.POINTS);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Points fop = (Points) o;
            return Objects.equals(this.amount, fop.amount) &&
                    Objects.equals(this.type, fop.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, type);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class Cash {\n");
            sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
            sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public static class Cash extends ApiFormOfPayment {
        private final Currency currency;

        public Cash(String amount, Currency currency) {
            super(amount, FormOfPaymentType.CASH);
            this.currency = currency;
        }

        public Currency getCurrency() {
            return currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cash fop = (Cash) o;
            return Objects.equals(this.amount, fop.amount) &&
                    Objects.equals(this.type, fop.type) &&
                    Objects.equals(this.currency, fop.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, type, currency);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class Cash {\n");
            sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
            sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
            sb.append("}");
            return sb.toString();
        }
    }

    public static class NonCash extends ApiFormOfPayment {
        private final Currency currency;

        public NonCash(String amount, Currency currency) {
            super(amount, FormOfPaymentType.NON_CASH);
            this.currency = currency;
        }

        public Currency getCurrency() {
            return currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NonCash fop = (NonCash) o;
            return Objects.equals(this.amount, fop.amount) &&
                    Objects.equals(this.type, fop.type) &&
                    Objects.equals(this.currency, fop.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, type, currency);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class NonCash {\n");
            sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
            sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
            sb.append("}");
            return sb.toString();
        }
    }


    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

