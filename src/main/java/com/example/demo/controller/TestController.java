package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String testController(){
        return "Hello Acon!";
    }

    @GetMapping("/{id}")
    public String testControllerPathVariable(@PathVariable(required = false) int id)
    {
        return "안녕 정윤아 난 널"+id+"만큼 사랑해";
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id)
    {
        return "안녕 정윤아 난 널"+id+"만큼 사랑해";
    }

    @PutMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "아이디는 : " + testRequestBodyDTO.getId() + "메세지는 : " + testRequestBodyDTO.getMessage();

    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("반갑습니다~~~");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;

    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("반갑습니다~~~ 400번 Status 입니다욤");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
//        return ResponseEntity.ok().body(response);

    }
}
