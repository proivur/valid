export interface SearchResponse {
    data:       Patient[];
    pagination: Pagination;
    meta:       Meta;
}

export interface Patient {
    type:                       Type;
    id:                         string;
    firstName:                  string;
    lastName:                   string;
    status:                     string;
}

export interface Analytics {
    onload:  Onclick;
    onclick: Onclick;
    onsent:  Onclick;
}

export interface Onclick {
    url: string;
}

export interface Meta {
    status:      number;
    msg:         string;
    response_id: string;
}

export interface Pagination {
    total_count: number;
    count:       number;
    offset:      number;
}
