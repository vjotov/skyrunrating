package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.model.CatModel;
import org.springframework.stereotype.Service;

@Service
public interface CatService {
    void buy(CatModel cat);

}
