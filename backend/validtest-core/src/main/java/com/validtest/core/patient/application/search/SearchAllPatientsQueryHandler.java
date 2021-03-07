package com.validtest.core.patient.application.search;

import com.validtest.core.patient.infrastructure.controller.PatientResponse;
import com.validtest.core.patient.infrastructure.controller.PatientsResponse;
import com.validtest.shared.domain.PatientNotExist;
import com.validtest.shared.domain.Service;
import com.validtest.shared.domain.bus.query.QueryHandler;
import org.springframework.data.domain.Page;

@Service
public final class SearchAllPatientsQueryHandler implements QueryHandler<SearchAllPatientsQuery, PatientsResponse> {

    private final AllPatientsSearcher searcher;

    public SearchAllPatientsQueryHandler(AllPatientsSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PatientsResponse handle(SearchAllPatientsQuery query) throws PatientNotExist {
        Page<PatientResponse> results = searcher.findAll(query.filter(), query.pageNo(), query.pageSize(), query.sortBy(), query.direction());

        return new PatientsResponse(results);
    }

}
