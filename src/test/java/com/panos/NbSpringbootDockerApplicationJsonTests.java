/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author p.stassinopoulos
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@JsonTest
public class NbSpringbootDockerApplicationJsonTests {
 //   @Test
 //   public void contextLoads() {
 //   }
        
    
   @MockBean
   private EmployeeRestController remoteService;
    
    @Autowired
    private JacksonTester<Employee> json;
    
 //   @Autowired
 //   private EmployeeRestController reverser;
        
    @Test
    public void exampleTest() {
        // RemoteService has been injected into the reverser bean
        given(this.remoteService.HelloWorld()).willReturn("mock");
        String reverse = remoteService.HelloWorld();
        assertThat(reverse).isEqualTo("mock");
    }
   

    @Test
    public void testSerialize() throws Exception {
        Employee details = new Employee("Panos", "pstassip@gmail.com");
        // Or use JSON path based assertions
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.email")
                .isEqualTo("pstassip@gmail.com");
    }
    
  // @Test
  //  public void testSerializeFile() throws Exception {
  //      Employee details = new Employee("Panos", "pstassip@gmail.com");
  //      // Assert against a `.json` file in the same package as the test
  //      assertThat(this.json.write(details)).isEqualToJson("expected.json");
  //  }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"name\":\"Panos\",\"email\":\"pstassip@gmail.com\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Employee("Panos", "pstassip@gmail.com"));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("Panos");
    } 
}


