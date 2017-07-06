/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.ignite;

import org.apache.ignite.lang.IgniteFuture;
import org.jetbrains.annotations.Nullable;

/**
 * Exception thrown from ignite cache API if cache is restarting.
 */
public class IgniteCacheRestartingException extends IgniteException {
    /** */
    private static final long serialVersionUID = 0L;

    /** */
    private final IgniteFuture<?> restartFut;

    /**
     * @param restartFut Restart future.
     * @param msg Error message.
     */
    public IgniteCacheRestartingException(IgniteFuture<?> restartFut, String msg) {
        this(restartFut, msg, null);
    }

    /**
     * @param restartFut Restart future.
     * @param msg Error message.
     * @param cause Optional nested exception (can be {@code null}).
     */
    public IgniteCacheRestartingException(
        IgniteFuture<?> restartFut,
        String msg,
        @Nullable Throwable cause) {
        super(msg, cause);

        this.restartFut = restartFut;
    }

    /**
     * @return Future that will be completed when cache is restarted.
     */
    public IgniteFuture<?> restartFuture() {
        return restartFut;
    }
}
