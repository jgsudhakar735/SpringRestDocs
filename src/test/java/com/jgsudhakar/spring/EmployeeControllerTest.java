package com.jgsudhakar.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgsudhakar.spring.entity.EmployeeEntity;
import com.jgsudhakar.spring.repository.EmployeeRepository;
import com.jgsudhakar.spring.rest.api.EmployeeController;
import com.jgsudhakar.spring.rest.dto.request.EmployeeReq;
import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;
import com.jgsudhakar.spring.service.EmployeeService;
import com.jgsudhakar.spring.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.EmployeeControllerTest
 * @Date : 13/11/2020
 */
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
public class EmployeeControllerTest {

    private static final String CONTENT_TYPE = "application/json";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private RestDocumentationResultHandler documentationHandler;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider contextProvider){
        this.documentationHandler = document("{methodName}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));

    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(documentationConfiguration(contextProvider))
            .alwaysDo(documentationHandler)
            .build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void shouldReturnDefaultList() throws Exception{

        this.mockMvc.perform(get("/api/employee/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sriyaan")))
                ;
    }

    @Test
    @Order(2)
    public void shouldSaveAndReturnEmployee() throws Exception{


        String empData = objectMapper.writeValueAsString(constructEmpReqData(null,"Venky","Tangellapalli"));
        this.mockMvc.perform(post("/api/employee/")
                .content(empData)
                .contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Venky")))
        ;
    }


    @Test
    @Order(3)
    public void shouldReturnEmployee() throws Exception{
        this.mockMvc.perform(get("/api/employee/13")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sudhakar")))
        ;
    }


    @Test
    @Order(4)
    public void shouldUpdateAndReturnEmployee() throws Exception{
        String empData = objectMapper.writeValueAsString(constructEmpReqData(13l,"Sudhakar","Tangellapalli"));
        this.mockMvc.perform(put("/api/employee/")
                .content(empData)
                .contentType(CONTENT_TYPE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sudhakar")))
        ;
    }

    @Test
    @Order(5)
    public void shouldDeleteAndReturnEmployee() throws Exception{
        this.mockMvc.perform(delete("/api/employee/13")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sudhakar")))
        ;
    }

    private EmployeeReq constructEmpReqData(Long id, String empName, String empLastName) {
        return new EmployeeReq(id,empName,empLastName);
    }
}
