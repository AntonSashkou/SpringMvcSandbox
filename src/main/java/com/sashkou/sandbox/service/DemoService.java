package com.sashkou.sandbox.service;

import com.sashkou.sandbox.model.CreateDemoRequest;
import com.sashkou.sandbox.model.DemoDTO;
import com.sashkou.sandbox.model.UpdateDemoRequest;

public interface DemoService {

    void create(CreateDemoRequest createDemoRequest);

    DemoDTO read(String id);

    void update(UpdateDemoRequest updateDemoRequest);

    void delete(String id);
}
