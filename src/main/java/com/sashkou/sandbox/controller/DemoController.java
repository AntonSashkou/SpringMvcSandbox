package com.sashkou.sandbox.controller;

import com.sashkou.sandbox.model.CreateDemoRequest;
import com.sashkou.sandbox.model.DemoDTO;
import com.sashkou.sandbox.model.UpdateDemoRequest;
import com.sashkou.sandbox.service.DemoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {
    private final DemoServiceImpl demoServiceImpl;

    @PostMapping
    public void create(@RequestBody CreateDemoRequest createDemoRequest) {
        demoServiceImpl.create(createDemoRequest);
    }

    @GetMapping
    public DemoDTO read(@RequestParam @NotNull String id) {
        return demoServiceImpl.read(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateDemoRequest updateDemoRequest) {
        demoServiceImpl.update(updateDemoRequest);
    }

    @DeleteMapping()
    public void delete(@RequestParam @NotNull String id) {
        demoServiceImpl.delete(id);
    }

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file) {
        log.info("uploading file '{}'", file.getOriginalFilename());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /*@ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(DemoNotFoundException.class)
    public DemoNotFoundException onDemoNotFound(DemoNotFoundException ex) {
        log.error(ex.getMessage());
        return ex;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public MissingServletRequestParameterException onMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error(ex.getMessage());
        return ex;
    }*/
}
