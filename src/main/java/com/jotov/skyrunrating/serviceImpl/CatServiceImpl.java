package com.jotov.skyrunrating.serviceImpl;

import com.jotov.skyrunrating.entity.Cat;
import com.jotov.skyrunrating.model.CatModel;
import com.jotov.skyrunrating.repository.CatRepository;
import com.jotov.skyrunrating.service.CatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatRepository catRepository;

    @Override
    public void buy(CatModel catModel) {
        Cat cat = this.modelMapper.map(catModel, Cat.class);
        this.catRepository.save(cat);
    }
}
