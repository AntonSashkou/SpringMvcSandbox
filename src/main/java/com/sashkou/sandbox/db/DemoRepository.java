package com.sashkou.sandbox.db;

import com.sashkou.sandbox.model.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DemoRepository {

    private final static List<DemoDTO> DEMO_LIST = new ArrayList<>();

    public void create(DemoDTO demoDTO) {
        DEMO_LIST.add(demoDTO);
        logStatus();
    }

    public Optional<DemoDTO> read(String id) {
        logStatus();
        return DEMO_LIST.stream().filter(demo -> demo.getId().equals(id)).findFirst();
    }

    public void update(DemoDTO newDemo) {
        DEMO_LIST.removeIf(demo -> demo.getId().equals(newDemo.getId()));
        DEMO_LIST.add(newDemo);
        logStatus();
    }

    public void delete(String id) {
        DEMO_LIST.removeIf(demo -> demo.getId().equals(id));
        logStatus();
    }

    private void logStatus() {
        log.info("DB status:");
        DEMO_LIST.forEach(demo -> log.info("demo: {}", demo));
    }
}
