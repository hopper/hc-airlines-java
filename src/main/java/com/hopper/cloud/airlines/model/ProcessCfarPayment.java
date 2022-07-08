package com.hopper.cloud.airlines.model;

import java.util.Objects;

public class ProcessCfarPayment {
    private boolean succeeded;

    public ProcessCfarPayment() {
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessCfarPayment processCfarPayment = (ProcessCfarPayment) o;
        return Objects.equals(this.succeeded, processCfarPayment.succeeded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(succeeded);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessCfarPayment {\n");
        sb.append("    succeded: ").append(toIndentedString(succeeded)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

