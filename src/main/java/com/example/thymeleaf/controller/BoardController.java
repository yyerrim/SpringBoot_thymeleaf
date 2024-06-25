package com.example.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.thymeleaf.entity.Board;
import com.example.thymeleaf.repository.BoardRepository;

@Controller
public class BoardController {
  @Autowired
  BoardRepository boardRepository;

  @GetMapping("/write")
  public String write() {
    return "write";
  }

  @PostMapping("/write")
  @ResponseBody
  public Board writePost(@ModelAttribute Board board) {
    boardRepository.save(board);
    return board; // JSON으로 출력
  }

  @GetMapping("/board")
  public String board(Model model) {
    List<Board> list = boardRepository.findAll();
    model.addAttribute("list", list);
    return "board";
  }

  @GetMapping("/board1")
  public String board1(Model model) {
    List<Board> list = boardRepository.findAll();
    model.addAttribute("list", list);
    String data = "<div><h1>Footer 제목</h1><h3>Footer 내용</h3></div>";
    model.addAttribute("data", data);
    return "board1";
  }

  @GetMapping("/board2")
  public String board2(Model model) {
    List<Board> list = boardRepository.findAll();
    model.addAttribute("list", list);
    return "board2";
  }

  @GetMapping("/board2/data")
  @ResponseBody
  public String board2() {
    String data = "<div><h1>Footer 제목</h1><h3>Footer 내용</h3></div>";
    return data;
  }

}
