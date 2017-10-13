package net.meshkorea.mcp.api.controller.bookmark;

import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkRequest;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkResponse;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.bookmark.BookmarkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/addBookmark")
    public BookmarkResponse.AddBookmark addBookmark(@Valid @RequestBody BookmarkRequest.AddBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.AddBookmark addBookmark = new BookmarkResponse.AddBookmark();
        addBookmark.setBookmark(bookmarkService.addBookmark(req));

        return addBookmark;
    }

    @PostMapping("/findBookmarks")
    public BookmarkResponse.FindBookmark findBookmarkList(
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "issueDt", direction = Sort.Direction.DESC),
                    @SortDefault(sort = "bmkType", direction = Sort.Direction.ASC),
                    @SortDefault(sort = "bmkNo", direction = Sort.Direction.DESC)
            })
            @PageableDefault(value = 100) final Pageable pageable,
            @Valid @RequestBody BookmarkRequest.FindBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.FindBookmark findBookmark = new BookmarkResponse.FindBookmark();
        findBookmark.setBookmarkList(bookmarkService.findBookmarkList(req, pageable));

        return findBookmark;
    }

    @PostMapping("/updateBookmark")
    public BookmarkResponse.UpdateBookmark updateBookmark(@Valid @RequestBody BookmarkRequest.UpdateBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.UpdateBookmark updateBookmark = new BookmarkResponse.UpdateBookmark();
        updateBookmark.setBookmark(bookmarkService.updateBookmark(req));

        return updateBookmark;
    }

    @PostMapping("/removeBookmark")
    public BookmarkResponse.RemoveBookmark removeBookmark(@Valid @RequestBody BookmarkRequest.RemoveBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.RemoveBookmark removeBookmark = new BookmarkResponse.RemoveBookmark();
        removeBookmark.setBookmark(bookmarkService.removeBookmark(req));

        return removeBookmark;
    }

    @PostMapping("/removeBookmark/all")
    public BookmarkResponse.Result removeBookmarkAll(@Valid @RequestBody BookmarkRequest.RemoveBookmarkAll req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.Result result = new BookmarkResponse.Result();
        result.setDone(bookmarkService.removeBookmarkAll(req));

        return result;
    }

    @PostMapping("/findBookmarks/count")
    public BookmarkResponse.CountBookmark findBookmarkListCount(@Valid @RequestBody BookmarkRequest.FindBookmark req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.CountBookmark countBookmark = new BookmarkResponse.CountBookmark();
        countBookmark.setCount(bookmarkService.getBookmarkCount(req));

        if (StringUtils.isNotEmpty(req.getBmkType())) {
            countBookmark.setBmkType(req.getBmkType());
        } else {
            countBookmark.setBmkType("all");
        }

        return countBookmark;
    }

    @PostMapping("/getBookmarkDetail")
    public BookmarkResponse.GetBookmarkDetail getBookmarkDetail(@Valid @RequestBody BookmarkRequest.GetBookmarkDetail req, BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        BookmarkResponse.GetBookmarkDetail getBookmarkDetail = new BookmarkResponse.GetBookmarkDetail();
        getBookmarkDetail.setBookmark(bookmarkService.getBookmarkDetail(req));

        return getBookmarkDetail;
    }

}
