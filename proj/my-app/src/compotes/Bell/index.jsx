import { HiOutlineBell } from 'react-icons/hi';
import styles from "./style.module.css";

export default function Bell({ notificationCount }) {
  return (
    <div className={styles.bellWrapper}>
      <HiOutlineBell className={styles.bellIcon} />
      {notificationCount > 0 && (
        <div className={styles.notificationCircle}>{notificationCount}</div>
      )}
    </div>
  );
}



