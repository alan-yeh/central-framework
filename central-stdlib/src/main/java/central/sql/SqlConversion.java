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

package central.sql;

import central.sql.data.Entity;

import java.lang.reflect.Field;

/**
 * Sql 与 Java 的命名转换
 *
 * @author Alan Yeh
 * @since 2022/08/05
 */
public interface SqlConversion {
    /**
     * 根据类生成表名
     *
     * @param type 类
     * @return 表名
     */
    String getTableName(Class<? extends Entity> type);

    /**
     * 根据字段生成列名
     *
     * @param property 属性名
     * @return 列名
     */
    String getColumnName(String property);

    /**
     * 根据列名生成属性名
     * @param column 列名
     * @return 属性名
     */
    String getPropertyName(String column);
}
