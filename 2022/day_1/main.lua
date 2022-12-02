package.path = package.path .. ";../lib/?.lua"
require "files"
require "strings"

local input = lines_from("input.txt")
local elfs = {}

local index = 1
for k, v in pairs(input) do
    if not elfs[index] then
        elfs[index] = 0
    end
    if #v > 0 then
        elfs[index] = elfs[index] + tonumber(v)
    else
        index = index + 1
    end
end

table.sort(elfs, function (k1, k2) return k1 > k2 end)

print(elfs[1])
print(elfs[1] + elfs[2] + elfs[3])