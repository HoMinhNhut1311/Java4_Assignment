package Util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import Util.JpaUtils;

public class QueryUtil<T> {
    
    public List<T> executeQueryList(String hql, Object... values) {
        try  {
        	EntityManager em = JpaUtils.getEntityManager();
            TypedQuery<T> query = em.createQuery(hql, (Class<T>) Object.class);

            // Thiết lập giá trị cho các tham số trong câu truy vấn
            int index = 1;
            for (Object value : values) {
                query.setParameter(index++, value);
            }
            // Thực thi câu truy vấn và trả về kết quả
            return query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý ngoại lệ nếu có
        }
        return null;
    }

    public T executeQuerySingle(String hql,String[] param, Object... values) {
        try  {
            System.out.println("Chuỗi: " + hql);
            EntityManager em = JpaUtils.getEntityManager();
            TypedQuery<T> query = em.createQuery(hql, (Class<T>) Object.class);
            
            // Thiết lập giá trị cho các tham số trong câu truy vấn
            int index = 1;
            if (param != null) {
            for (int i = 0; i < param.length; i++) {
				query.setParameter(param[i], values[i]);
			}
            }
         query.setMaxResults(1);
            
            // Thực thi câu truy vấn và trả về kết quả duy nhất
            return query.getSingleResult();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Không tồn tại");
        }
        return null;
    }

}
