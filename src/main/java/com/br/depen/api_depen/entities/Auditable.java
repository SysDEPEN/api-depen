package com.br.depen.api_depen.entities;

import java.util.Date;

public interface Auditable {
    void setCreatedAt(Date date);
    void setUpdatedAt(Date date);
}
