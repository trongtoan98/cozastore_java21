package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.ColorEntity;
import com.cybersoft.cozastore_java21.payload.response.ColorResponse;
import com.cybersoft.cozastore_java21.repository.ColorRepository;
import com.cybersoft.cozastore_java21.service.imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements ColorServiceImp {
//    inject Repository vào
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<ColorResponse> getAllColor() {
        List<ColorEntity> entityList = colorRepository.findAll();
        List<ColorResponse> responseList = new ArrayList<>();

        for(ColorEntity data : entityList){

            ColorResponse colorResponse = new ColorResponse();
            colorResponse.setId(data.getId());
            colorResponse.setName(data.getName());

            responseList.add(colorResponse);
        }

        return responseList;
    }
}
