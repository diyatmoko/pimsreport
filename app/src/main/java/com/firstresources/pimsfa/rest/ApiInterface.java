/*
 * Copyright (c) 2019 Yanuar Diyatmoko. All Rights Reserved.
 * <p>
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Yanuar Diyatmoko.
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 */

package com.firstresources.pimsfa.rest;

import com.firstresources.pimsfa.model.ReportFAHarian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 03/05/2019
 */
public interface ApiInterface {

    @GET("reporting/getreportfaharian")
    Call<List<ReportFAHarian>> getReportFAHarian();

}
