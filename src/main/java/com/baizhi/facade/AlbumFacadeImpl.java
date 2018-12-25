package com.baizhi.facade;


import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class AlbumFacadeImpl implements AlbumFacade {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AlbumService albumService;



    @Override
    public void AlbumDeleteFile(Album album,HttpServletRequest request) {
        Album queryByidAlbum = albumService.queryByid(album);//得到我所需要的数据支撑
        String id = queryByidAlbum.getId();
        String cover = queryByidAlbum.getCover();//得到封面图片
        String realPath = request.getSession().getServletContext().getRealPath(cover);//得到封面的绝对路径
        File file = new File(realPath, cover);//得到封面的图片
        file.delete();//进行删除

        Boolean ble=true;
        List<Chapter> chapters = chapterService.queryAllByPid(id);
        /*接下来我需要获得我每一个章节所有对应的文件的路径 */
        for (Chapter chapterList : chapters) {
            String chapterId = chapterList.getId();
            String downpath = chapterList.getDownpath();//获得文件的相对路径
            String albumtitle = chapterList.getAlbumtitle();//获得文件的名字
            String chaptersRealPath = request.getSession().getServletContext().getRealPath(downpath);//获得文件的绝对路径
            File chapterFile = new File(chaptersRealPath, chapterId+albumtitle);//得到我的章节视频文件
            chapterFile.delete();//删除文件
            /*蹲点判断 确定在循环的第一次进入并在其他时候 并基于判断失误的条件判断*/
            if(ble){
                chapterService.deleteChapter(chapterList);//全部删除所有父id 为这个id的章节
                albumService.delete(album);
                ble=false;
            }
        }
    }

    public void addCount(String id){
        Album album=new Album();
        album.setId(id);
        Album queryByidAlbum = albumService.queryByid(album);//得到我所需要的数据支撑
        Integer integer = albumService.queryCount(album.getId());
        String count = String.valueOf(integer);
        queryByidAlbum.setCount(count);
        albumService.updateAlbum(queryByidAlbum);

    }
}
