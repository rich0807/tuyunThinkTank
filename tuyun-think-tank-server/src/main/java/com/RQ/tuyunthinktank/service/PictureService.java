package com.RQ.tuyunthinktank.service;

import com.RQ.tuyunthinktank.model.dto.picture.PictureByBatchRequest;
import com.RQ.tuyunthinktank.model.dto.picture.PictureQueryRequest;
import com.RQ.tuyunthinktank.model.dto.picture.PictureReviewRequest;
import com.RQ.tuyunthinktank.model.dto.picture.PictureUploadRequest;
import com.RQ.tuyunthinktank.model.entity.Picture;
import com.RQ.tuyunthinktank.model.entity.User;
import com.RQ.tuyunthinktank.model.vo.PictureVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author RQ
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-06-08 21:53:08
*/
public interface PictureService extends IService<Picture> {
    /**
     * @description 校验图片信息
     * @author RQ
     * @date 2025/6/13 下午4:04
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);
/**
 * @description 分页查询
 * @author RQ
 * @date 2025/6/13 下午3:19
 */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

 /**
  * @description 封装图片VO，单条数据脱敏
  * @author RQ
  * @date 2025/6/13 下午3:31
  */
    PictureVO getPictureVO(Picture picture,  HttpServletRequest request);
/**
 * @description 封装图片VO，分页数据脱敏
 * @author RQ
 * @date 2025/6/13 下午5:37
 */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage);

    /**
     * @description 图片审核
     * @return: void
     * @author RQ
     * @date: 2025/7/8 上午10:01
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * @description 设置审核状态
     * @author RQ
     * @date 2025/7/9 下午2:01
     */
    //设置审核状态
    void setPictureReviewStatus(Picture picture, User loginUser);
/**
 * @return
 * @description 批量抓取图片
 * @author RQ
 * @date 2025/7/17 上午9:13
 */
    int doPictureBatchUpload(PictureByBatchRequest pictureByBatchRequest, User loginUser);

/**
 * @description 分页查询图片cache
 * @author RQ
 * @date 2025/7/19 下午5:28
 */
    Page<PictureVO> listPictureVOByPageWithCache(PictureQueryRequest pictureQueryRequest, HttpServletRequest request);
}
