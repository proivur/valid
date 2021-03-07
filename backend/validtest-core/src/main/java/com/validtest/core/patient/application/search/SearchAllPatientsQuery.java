package com.validtest.core.patient.application.search;

import com.validtest.shared.domain.bus.query.Query;

public class SearchAllPatientsQuery implements Query {

    private String filter;
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String direction;

    public SearchAllPatientsQuery() {
        super();
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private SearchAllPatientsQuery searchAllPatientsQuery;

        public Builder() {
            this.searchAllPatientsQuery = new SearchAllPatientsQuery();
        }

        public Builder withFilter(String filter) {
            this.searchAllPatientsQuery.filter = filter;

            return this;
        }

        public Builder withPageNo(Integer pageNo) {
            this.searchAllPatientsQuery.pageNo = pageNo;

            return this;
        }

        public Builder withPageSize(Integer pageSize) {
            this.searchAllPatientsQuery.pageSize = pageSize;

            return this;
        }

        public Builder withSortBy(String sortBy) {
            this.searchAllPatientsQuery.sortBy = sortBy;

            return this;
        }

        public Builder withDirection(String direction) {
            this.searchAllPatientsQuery.direction = direction;

            return this;
        }

        public SearchAllPatientsQuery build() {
            return this.searchAllPatientsQuery;
        }

    } // inner class

    public String filter() {
        return filter;
    }

    public Integer pageNo() {
        return pageNo;
    }

    public Integer pageSize() {
        return pageSize;
    }

    public String sortBy() {
        return sortBy;
    }

    public String direction() {
        return direction;
    }

}
