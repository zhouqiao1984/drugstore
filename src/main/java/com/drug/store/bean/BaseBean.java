package com.drug.store.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * com.drug.store.pojo
 *
 * @desc 实体类的父类实体类的父类
 * @author:EumJi
 * @year: 2016
 * @month: 10
 * @day: 17
 * @time: 2016/10/17
 */

public class BaseBean implements Serializable {

    private String remark;  //注释

    private String creator;     //创建人

    private String createDate;    //创建时间

    private String editor;      //编辑人

    private String editDate;  //编辑时间


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

	@Override
	public String toString() {
		return "BaseBean [remark=" + remark + ", creator=" + creator + ", createDate=" + createDate + ", editor="
				+ editor + ", editDate=" + editDate + "]";
	}
    
    
}
