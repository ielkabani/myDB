package com.elkabani.mydb.controllers;

import com.elkabani.mydb.dtos.RegisterUserRequest;
import com.elkabani.mydb.dtos.UpdateUserRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import com.elkabani.mydb.mappers.UserMapper;
import com.elkabani.mydb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/ui/users")
public class UserUIController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public String listUser(Model model, @RequestParam(defaultValue="name") String sort)
    {
        var users = userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();

        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model)
    {
        model.addAttribute("user", new RegisterUserRequest());
        model.addAttribute("isEdit", false);
        return "users/form";
    }

    @PostMapping
    public String createUser(@ModelAttribute RegisterUserRequest request, RedirectAttributes redirectAttributes)
    {
        var user = userMapper.toEntity(request);
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("successMessage", "User Created successfully!");
        return "redirect:/ui/users";
    }

    @GetMapping("/{id}")
    public String viewUser (@PathVariable Long id, Model model, RedirectAttributes redirectAttributes)
    {
        var user = userRepository.findById(id).orElse(null);
        if(user==null)
        {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
            return "redirect:ui/users";
        }
        model.addAttribute("user", userMapper.toDto(user));
        return "users/view";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes)
    {
        var user = userRepository.findById(id).orElse(null);
        if(user==null) {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
            return "redirect:/ui/users";
        }
        var updateRequest = new UpdateUserRequest();
        updateRequest.setName(user.getName());
        updateRequest.setEmail(user.getEmail());
        model.addAttribute("user", updateRequest);
        model.addAttribute("userId", id);
        model.addAttribute("isEdit", true);
        return "users/form";
    }

    @PutMapping("/{id}")
    public String updateUSer(@PathVariable Long id, @ModelAttribute UpdateUserRequest request,
                             RedirectAttributes redirectAttributes)
    {
        var user = userRepository.findById(id).orElse(null);
        if(user==null)
        {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
            return "redirect:/ui/users";
        }
        userMapper.update(request, user);
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("successMessage", "User updated successfully!");
        return "redirect:/ui/users/"+id;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes)
    {
        var user = userRepository.findById(id).orElse(null);
        if(user==null) {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
            return "redirect:/ui/users";
        }
        userRepository.delete(user);
        redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully!");
        return "redirect:/ui/users";
    }
}
