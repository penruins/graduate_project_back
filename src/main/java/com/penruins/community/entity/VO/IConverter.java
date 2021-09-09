package com.penruins.community.entity.VO;

public interface IConverter<T,E> {
  E convertToVO(T t);
}
