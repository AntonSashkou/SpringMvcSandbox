package com.sashkou.sandbox;

import com.sashkou.sandbox.controller.DemoController;
import com.sashkou.sandbox.exception.DemoNotFoundException;
import com.sashkou.sandbox.model.DemoDTO;
import com.sashkou.sandbox.service.DemoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Ways to test MVC application:
 * 1. Start the application and listen for a connection (as it would do in production) and then send an HTTP request and assert the response.
 * 2. Not start the server at all but to test only the layer below that, where Spring handles the incoming HTTP request and hands it off to controller.
 * 3. Test only web layer (@WebMvcTest)
 */

@WebMvcTest(controllers = DemoController.class)
public class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DemoServiceImpl service;

    @Test
    public void testReadDemoShouldReturnNotFound() throws Exception {
        var testId = UUID.randomUUID().toString();
        var expected = String.format("demo %s not found", testId);

        when(service.read(testId)).thenThrow(new DemoNotFoundException(String.format("demo %s not found", testId)));

        this.mockMvc.perform(get(String.format("/demo?id=%s", testId)))
                .andExpect(status().isNotFound())
                .andExpect(content().string(expected));
    }

    @Test
    public void testReadDemoShouldReturnEntity() throws Exception {
        var testId = UUID.randomUUID().toString();
        var testName = UUID.randomUUID().toString();
        var testDemoDTO = new DemoDTO();
        testDemoDTO.setId(testId);
        testDemoDTO.setName(testName);

        when(service.read(testId)).thenReturn(testDemoDTO);
        var expected = String.format("{\"id\":\"%s\",\"name\":\"%s\"}", testId, testName);

        this.mockMvc.perform(get(String.format("/demo?id=%s", testId)))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}