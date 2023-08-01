package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.SizeEntity;
import com.cybersoft.cozastore_java21.payload.response.SizeResponse;
import com.cybersoft.cozastore_java21.repository.SizeRepository;
import com.cybersoft.cozastore_java21.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SizeService implements SizeServiceImp {
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public List<SizeResponse> getAllSize(){
        List<SizeEntity> list = sizeRepository.findAll();
        List<SizeResponse> listResponse = new ArrayList<>();

        for(SizeEntity data : list){
            SizeResponse sizeResponse = new SizeResponse();
            sizeResponse.setId(data.getId());
            sizeResponse.setName(data.getName());

            listResponse.add(sizeResponse);
        }
        return listResponse;
    }

}
