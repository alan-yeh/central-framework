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

package central.security;

import central.security.signer.SignerImpl;
import central.security.signer.impl.*;
import lombok.experimental.UtilityClass;

/**
 * 数字签名算法
 *
 * @author Alan Yeh
 * @since 2022/07/10
 */
@UtilityClass
public class Signerx {
    /**
     * RSA 256 签名算法
     */
    public static final SignerImpl RSA_256 = new RSA256Impl();

    /**
     * RSA 384 签名算法
     */
    public static final SignerImpl RSA_384 = new RSA384Impl();

    /**
     * RSA 512 签名算法
     */
    public static final SignerImpl RSA_512 = new RSA512Impl();

    /**
     * SM2 签名算法
     */
    public static final SignerImpl SM2 = new SM2Impl();

    /**
     * ECDSA 256 签名算法
     */
    public static final SignerImpl ECDSA_256 = new ECDSA256Impl();

    /**
     * ECDSA 384 签名算法
     */
    public static final SignerImpl ECDSA_384 = new ECDSA384Impl();

    /**
     * ECDSA 512 签名算法
     */
    public static final SignerImpl ECDSA_512 = new ECDSA512Impl();
}
