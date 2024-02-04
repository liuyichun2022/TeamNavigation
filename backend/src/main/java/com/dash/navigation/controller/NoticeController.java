package com.dash.navigation.controller;

import com.dash.navigation.domain.dto.NoticeDto;
import com.dash.navigation.domain.vo.NoticeVo;
import com.dash.navigation.common.constants.TeamNavConstants;
import com.dash.navigation.service.NoticeService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoticeController.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@RestController
@RequestMapping(TeamNavConstants.API_V1 + "/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    /**
     * select
     *
     * @param status status
     * @return List
     */
    @GetMapping
    public ResponseEntity<List<NoticeVo>> select(Boolean status) {
        return ResponseEntity.ok(noticeService.select(status));
    }

    /**
     * add
     *
     * @param noticeDto noticeDto
     * @return Void
     */
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody NoticeDto noticeDto) {
        noticeService.save(null, noticeDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * update
     *
     * @param id id
     * @param noticeDto noticeDto
     * @return Void
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id,
            @RequestBody NoticeDto noticeDto) {
        noticeService.save(id, noticeDto);
        return ResponseEntity.noContent().build();
    }

    /**
     * changeSort
     *
     * @param before before
     * @param after after
     * @return Void
     */
    @PatchMapping("/actions/sort")
    public ResponseEntity<Void> changeSort(@RequestParam Integer before, @RequestParam Integer after) {
        noticeService.changeSort(before, after);
        return ResponseEntity.noContent().build();
    }

    /**
     * delete
     *
     * @param id id
     * @return Void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        noticeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
