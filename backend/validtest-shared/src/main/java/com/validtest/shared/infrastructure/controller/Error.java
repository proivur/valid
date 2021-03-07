package com.validtest.shared.infrastructure.controller;

public final class Error {

    private final String source;
    private final String title;
    private final String detail;

    public Error(String source, String title, String detail) {
        this.source = source;
        this.title = title;
        this.detail = detail;
    }

    public static ErrorBuilder builder() {
        return new ErrorBuilder();
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetail() {
        return this.detail;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Error)) return false;
        final Error other = (Error) o;
        final Object this$source = this.getSource();
        final Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$detail = this.getDetail();
        final Object other$detail = other.getDetail();
        if (this$detail == null ? other$detail != null : !this$detail.equals(other$detail)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $source = this.getSource();
        result = result * PRIME + ($source == null ? 43 : $source.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $detail = this.getDetail();
        result = result * PRIME + ($detail == null ? 43 : $detail.hashCode());
        return result;
    }

    public String toString() {
        return "Error(source=" + this.getSource() + ", title=" + this.getTitle() + ", detail=" + this.getDetail() + ")";
    }

    public static class ErrorBuilder {
        private String source;
        private String title;
        private String detail;

        ErrorBuilder() {
        }

        public ErrorBuilder source(String source) {
            this.source = source;
            return this;
        }

        public ErrorBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ErrorBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Error build() {
            return new Error(source, title, detail);
        }

        public String toString() {
            return "Error.ErrorBuilder(source=" + this.source + ", title=" + this.title + ", detail=" + this.detail + ")";
        }
    }
}
