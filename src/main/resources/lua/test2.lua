local key = KEYS[1]
local value = ARGV[1]
local expire = ARGV[2]

redis.log(redis.LOG_NOTICE, "key is: " .. key)
redis.log(redis.LOG_NOTICE, "value is: " .. tostring(value))
redis.log(redis.LOG_NOTICE, "expire is: " .. tostring(expire))

local getResult = redis.call("get", key)
redis.log(redis.LOG_NOTICE, "result is: " .. tostring(getResult))
if getResult == false then
    local setResult = redis.call("set", key, value)
    if setResult then
        if tonumber(expire) > 0 then
            redis.call("expire", key, expire)
        else
            redis.log(redis.LOG_NOTICE, "expire must greater than 0")
            return false
        end
    else
        redis.log(redis.LOG_NOTICE, "set fail")
        return false
    end
end
return true
