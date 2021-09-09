package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author penruins
 * @since 2021-04-15
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class MessagePO implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String user_id;

    private String title;

    private String content;

    private String create_at;


  @TableLogic
  private Integer deleted;


}
