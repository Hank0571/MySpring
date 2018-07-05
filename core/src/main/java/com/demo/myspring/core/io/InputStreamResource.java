package com.demo.myspring.core.io;

import java.io.InputStream;

/**
 * Interface for a given inputStream.
 *
 * Created by Marter on 6/25/18.
 */
public interface InputStreamResource {

    /**
     * Get the underlying stream.
     *
     * @return
     */
    InputStream getInputStream();
}
