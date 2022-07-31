package com.sashkou.sandbox.service;

import com.sashkou.sandbox.db.DemoRepository;
import com.sashkou.sandbox.exception.DemoNotFoundException;
import com.sashkou.sandbox.model.CreateDemoRequest;
import com.sashkou.sandbox.model.DemoDTO;
import com.sashkou.sandbox.model.UpdateDemoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;
    private final DemoMapper demoMapper;
    @Override
    public void create(CreateDemoRequest createDemoRequest) {
        var demoDTO = demoMapper.createDemoRequestToDemoDTO(createDemoRequest);
        demoDTO.setId(UUID.randomUUID().toString());

        demoRepository.create(demoDTO);
    }

    @Override
    public DemoDTO read(String id) {
        var maybeDemo = demoRepository.read(id);

        return maybeDemo.orElseThrow(() -> new DemoNotFoundException(String.format("demo %s not found", id)));
    }

    @Override
    public void update(UpdateDemoRequest updateDemoRequest) {
        demoRepository.update(demoMapper.updateDemoRequestToDemoDTO(updateDemoRequest));
    }

    @Override
    public void delete(String id) {
        demoRepository.delete(id);
    }
}
