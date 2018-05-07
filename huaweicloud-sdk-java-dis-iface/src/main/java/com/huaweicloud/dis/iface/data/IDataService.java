/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaweicloud.dis.iface.data;

import com.huaweicloud.dis.iface.data.request.GetPartitionCursorRequest;
import com.huaweicloud.dis.iface.data.request.GetRecordsRequest;
import com.huaweicloud.dis.iface.data.request.PutRecordsRequest;
import com.huaweicloud.dis.iface.data.response.GetPartitionCursorResult;
import com.huaweicloud.dis.iface.data.response.GetRecordsResult;
import com.huaweicloud.dis.iface.data.response.PutRecordsResult;

/**
 * DIS服务的数据面接口
 * 
 * 这个接口实现了protobuf，如果要改结构，请同步修改protobuf定义以及protobuf对象和该entity的转换@see {@link ProtobufUtils}
 * */
public interface IDataService
{
    
    /**
     * <p>
     * 上传多条数据到DIS实例中。每个Partition提供1MB/秒数据输入和2MB/秒数据输出容量。
     * </p>
     * 
     * @param putRecordsParam 上传多条数据的请求参数
     * @return 批量上传数据操作的响应结果
     */
    PutRecordsResult putRecords(PutRecordsRequest putRecordsParam);

    
    /**
     * <p>
     * 用户获取迭代器，根据迭代器获取一次数据和下一个迭代器。
     * </p>
     * 
     * @param getShardIteratorParam 用户获取迭代器的请求参数
     * @return 获取迭代器的响应结果
     */
    GetPartitionCursorResult getPartitionCursor(GetPartitionCursorRequest getShardIteratorParam);
    
    /**
     * <p>
     * 从DIS实例中下载数据。
     * </p>
     * 
     * @param getRecordsParam 下载数据的请求参数
     * @return 下载数据的响应结果
     */
    GetRecordsResult getRecords(GetRecordsRequest getRecordsParam);
    
}