package dev.web.restcall;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController
{

    private String url = "https://api.restful-api.dev/objects";

    @GetMapping("/greet")
    public String  greetMsg()
    {
        return "Welcone User : "+new java.util.Date();
    }

    @GetMapping("/")
    public String index(Model model)
    {
        User userObj = new User();

        model.addAttribute("user", userObj);

        return "index";
    }


    @PostMapping("/saveRecord")
    public String handleSubmitBtn(User user, Model model)
    {
        System.out.println(user);
        model.addAttribute("msg", user.getUname() + " added successfully..!!");
        model.addAttribute("fullRec", user);

        return "success";
    }

    @GetMapping("/list")
    public String testMode(Model model)
    {
        ArrayList<User> list = getUsers();
        Product[] products = getRestContents();

        System.out.println(" Inside Model "+new java.util.Date());
        model.addAttribute("message", "Default User List");
        model.addAttribute("linkpage", "Rest Objects: "+url);
        model.addAttribute("users", list);
        model.addAttribute("products_list", products );

        return "productlist";
    }

    public ArrayList<User> getUsers()
    {
        User u1 = new User();
        u1.setUname("Nara");
        u1.setEmail("web@mail.com");

        User u2 = new User();
        u2.setUname("Chow");
        u2.setEmail("chow@mail.com");

        ArrayList<User> users = new ArrayList<>();

        users.add(u1);
        users.add(u2);

        this.getRestContents();

        return users;

    }

    public Product[] getRestContents()
    {
//        String url = "https://api.restful-api.dev/objects/{id}";

        RestTemplate rt = new RestTemplate();
        ResponseEntity<Product[]> forEntity = rt.getForEntity(url, Product[].class);
        Product[] products = forEntity.getBody();

        // for (Product p : products) {
        //   System.out.println(p.getName());
        // }

        // String body = forEntity.toString();
        //System.out.println(body);

        return products;

    }
}
