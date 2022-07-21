/*
 * MIT License
 *
 * Copyright (c) 2022-present Alan Yeh <alan@yeh.cn>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package central.util;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Array 工具
 *
 * @author Alan Yeh
 * @since 2022/07/12
 */
public class Arrayx {

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> boolean isNullOrEmpty(@Nullable T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> boolean isNotEmpty(@Nullable T[] array) {
        return array != null && array.length != 0;
    }

    /**
     * 转成 Stream
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> Stream<T> asStream(@Nullable T[] array) {
        return isNullOrEmpty(array) ? Stream.empty() : Arrays.stream(array);
    }

    /**
     * 获取第一个元素
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> T getFirst(@Nullable T[] array) {
        return isNullOrEmpty(array) ? null : array[0];
    }

    /**
     * 获取最后一个元素
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> T getLast(@Nullable T[] array) {
        return isNullOrEmpty(array) ? null : array[array.length - 1];
    }

    /**
     * 获取指定下标的元素
     *
     * @param array 数组
     * @param <T>   数组类型
     */
    public static <T> T get(@Nullable T[] array, int index) {
        if (array == null || array.length <= index) {
            return null;
        } else {
            return array[index];
        }
    }

    /**
     * 新建数组
     *
     * @param elements 元素
     * @param <T>      元素类型
     */
    @SafeVarargs
    public static <T> T[] newArray(T... elements) {
        return elements;
    }
}
