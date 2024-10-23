package com.example.myboard.board.controller;

import com.example.myboard.board.model.BoardRequest;
import com.example.myboard.board.model.BoardResponse;
import com.example.myboard.board.model.BoardViewResponse;
import com.example.myboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("")
    public BoardResponse create(
            @Valid @RequestBody BoardRequest boardRequest
    ) {
        return boardService.create(boardRequest);
    }

    @GetMapping("/all")
    public List<BoardViewResponse> getAllBoards() {
        return boardService.getAllBoards();
    }
}
