package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.CommentDao;
import com.bgs.BoardGameSelector.dao.UserDao;
import com.bgs.BoardGameSelector.model.Comment;
import com.bgs.BoardGameSelector.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserDao userDao;

    @Value("${UPLOAD_PATH_DIR}")
    private String uploadDir;

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile uploadedFile,
                                   RedirectAttributes redirectAttributes) {
        try {

            // Get the file and save it somewhere
            if(! new File(uploadDir).exists())
            {
                new File(uploadDir).mkdir();
            }

            // Write file to system
            File destDir = new File(uploadDir);
            File dest = File.createTempFile("img_", ".jpg", destDir);
            uploadedFile.transferTo(dest);

            // Update DN
            User user = userDao.findByUsername(getLoggedInUsername());
            user.setAvatar(dest.getName());
            userDao.save(user);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + uploadedFile.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "redirect:/account";
    }

    private String getLoggedInUsername() {
        // Get username of logged-in user
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }
        return username;
    }

    private long getLoggedInId() {
        String username = getLoggedInUsername();
        if (username.equals("anonymousUser"))
            return -1;
        User user = userDao.findByUsername(username);
        return user.getId();
    }

}
