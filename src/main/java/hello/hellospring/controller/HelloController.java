package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!test");
        return  "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //별 쓸일은 없음 http의 body에 값 넣는것
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){

        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   //리스폰스바디에 객체가 있으면 json으로 전달 / 문자가있으면 문자를 전달 //JsonConverter, StringConverter
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();  //자동 완성 할때 command + sheet + enter 하면 세미클론까지 완성해줌 sheet 없으면 세미클론 없음
        hello.setName(name);
        return hello;
    }

    static class Hello{
         public String name;

         //command + N -> get and set 검색 가능
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
