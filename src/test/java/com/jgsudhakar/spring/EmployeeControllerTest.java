package com.jgsudhakar.spring;

import com.jgsudhakar.spring.rest.api.EmployeeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
@WebMvcTest(EmployeeController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultList() throws Exception{
        this.mockMvc.perform(get("/api/employee/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Sriyaan")))
                .andDo(document("{methodName}",preprocessRequest(prettyPrint()),preprocessResponse(prettyPrint())))
                ;
    }
}
