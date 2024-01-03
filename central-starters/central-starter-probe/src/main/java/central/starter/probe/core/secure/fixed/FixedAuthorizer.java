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

package central.starter.probe.core.secure.fixed;

import central.starter.probe.core.ProbeException;
import central.starter.probe.core.secure.Authorizer;
import central.validation.Label;
import central.validation.Validatex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import java.util.Objects;

/**
 * 固定凭证监权
 *
 * @author Alan Yeh
 * @since 2024/01/03
 */
public class FixedAuthorizer implements Authorizer, InitializingBean {

    @Setter
    @NotBlank
    @Size(max = 1024)
    @Label("凭证")
    private String secret;

    @Override
    public void afterPropertiesSet() throws Exception {
        Validatex.Default().validate(this);
    }

    @Override
    public void authorize(String authorization) {
        if (!Objects.equals(this.secret, authorization)) {
            throw new ProbeException("凭证认证失败");
        }
    }
}
