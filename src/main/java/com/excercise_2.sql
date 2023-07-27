SELECT T1.*
FROM public.T1
LEFT JOIN public.T2 ON T1.name = T2.name
WHERE T2.name IS NULL
ORDER BY T1.name;