---
--- Generated by EmmyLua(https://github.com/EmmyLua)
--- Created by My.
--- DateTime: 2020/1/6 15:03
---lua脚本测试
local key1 = KEYS[1]
local key2 = KEYS[2]
--获取ARGV[1],这里对应到应用端是一个map
-- 注意，这里接收到是的json字符串，所以需要用csjon库把它解码成表
local receiveArg = cjson.decode(ARGV[1])
-- 返回值
local result = {}

-- 打印日志到redis
-- 注意，这里的打印日志级别，需要和redis.conf配置文件中的日志设置级别一致才行
redis.log(redis.LOG_NOTICE, key1)
redis.log(redis.LOG_NOTICE, key2)
redis.log(redis.LOG_NOTICE, ARGV[1], #ARGV[1])

--获取ARGV内的参数并打印
local expire = receiveArg.expire
local times = receiveArg.times
redis.log(redis.LOG_NOTICE, tostring(times))
redis.log(redis.LOG_NOTICE, tostring(expire))

redis.call("set", key1, times)
redis.call("incr", key2)
redis.call("expire", key2, expire)

--用一个临时变量来存放json,json是要放入要返回的数组中的
local jsonRedisTemp = {}
jsonRedisTemp[key1] = redis.call("get", key1)
jsonRedisTemp[key2] = redis.call("get", key2)
jsonRedisTemp["ttl"] = redis.call("ttl", key2)
redis.log(redis.LOG_NOTICE, cjson.encode(jsonRedisTemp))

--springboot redistemplate接收的是List,如果返回的数组内容是json对象,需要将json对象转成字符串,客户端才能接收
result[1] = cjson.encode(jsonRedisTemp)
result[2] = ARGV[1] --将源参数内容一起返回
----打印数组结果(字符串表示)
redis.log(redis.LOG_NOTICE, cjson.encode(result))

return result