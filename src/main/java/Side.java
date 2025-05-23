// The reason I am using javax.persistence here is that we have added the Hibernate-Ehcache dependency
// in the pom.xml with the same version. Currently, there is no new version of Ehcache that supports
// Jakarta Persistence (jakarta.persistence), but Hibernate 6.x uses Jakarta Persistence.
// Therefore, we continue using javax.persistence for compatibility.

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)  // The READ_ONLY strategy ensures the data cannot be changed.
// This is ideal for static data that never changes, like country names or currency codes.
// If you try to update data marked as READ_ONLY, Hibernate will throw an exception.
public class Side {
    @Id
    @Column
    private int rool_Number;

    @Column
    private String Name;

    @Column
    private String Education;

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRool_Number() {
        return rool_Number;
    }

    public void setRool_Number(int rool_Number) {
        this.rool_Number = rool_Number;
    }

    @Override
    public String toString() {
        return this.getEducation() + " " + this.getRool_Number() + " " + this.getName();
    }
}

