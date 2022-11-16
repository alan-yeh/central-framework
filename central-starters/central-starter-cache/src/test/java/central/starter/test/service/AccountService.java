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

package central.starter.test.service;

import central.sql.Conditions;
import central.sql.Orders;
import central.starter.cache.core.annotation.CacheEvict;
import central.starter.cache.core.annotation.CacheKey;
import central.starter.cache.core.annotation.Cacheable;
import central.starter.test.service.data.Account;
import central.starter.test.service.data.Department;
import central.util.Guidx;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Test Service
 *
 * @author Alan Yeh
 * @since 2022/11/15
 */
@Service
public class AccountService {

    @Setter(onMethod_ = @Autowired)
    private DepartmentService departments;
    private final AtomicInteger index = new AtomicInteger();

    @Cacheable(key = "account:id:${args[0]}")
    public Account findById(String id) {
        var account = new Account();
        account.setId(id);
        account.setName("帐号 " + index + index.getAndIncrement());
        account.setDepartmentId(id.toLowerCase());
        account.setDepartment(departments.findById(account.getDepartmentId()));
        account.updateCreator("syssa");
        return account;
    }

    @Cacheable(key = "account:findBy:${sign(args)}", dependencies = "account:id:any")
    public List<Account> findBy(Long first, Long offset, Conditions<Account> conditions, Orders<Account> orders) {
        return IntStream.range(index.incrementAndGet(), index.get() + 10).mapToObj(it -> {
            var account = new Account();
            account.setId(Guidx.nextID());
            account.setName("帐号 " + it);
            account.setDepartmentId(Guidx.nextID());
            account.setDepartment(departments.findById(account.getDepartmentId()));
            account.updateCreator("syssa");
            return account;
        }).toList();
    }

    @CacheEvict(keys = @CacheKey(key = "account:id:${it}", it = "args[0]"))
    @CacheEvict(key = "account:id:any")
    public long deleteByIds(List<String> ids) {
        return 1;
    }
}
