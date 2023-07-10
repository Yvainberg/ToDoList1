import { useState, useEffect } from "react";
import styles from "./style.module.css";
import { useContext } from 'react'
import DataContext from "../context/dataContext";
import ListCreationForm from "../pages/ListCreationForm";
import RequestAxios from "../function/RequestAxios";
import { format } from "date-fns";
import Bell from "../compotes/Bell";
import AppRegistrationRoundedIcon from '@mui/icons-material/AppRegistrationRounded';

export default function Header() {
  const { loading, setLoading, setIsOpen, setpopupComponent } = useContext(DataContext);
  // Tasks for today
  const [day, setDay] = useState(format(new Date(), "yyyy-MM-dd"))
  const [taskToday, setTaskToday] = useState()

  const hendleTasksPopup = () => {
    ;
    setpopupComponent(<ListCreationForm />);
    setIsOpen(true);
  };

  const fetchDate = async () => {
    // const today = format(new Date(), "yyyy-MM-dd");
    try {
      setLoading(true);
      const response = await RequestAxios("/todolist/countByStartDate", "POST", { startdate: day });
      setTaskToday(response.data)
      setLoading(false);

    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchDate();
  }, [loading]);



  return (
    <div className={styles.header}>
       <div className={styles.headerContent}>
           <AppRegistrationRoundedIcon className={styles.icon} />
            <h1 className={styles.caption}>TO DO LIST</h1>
            <div className={styles.bellWrapper}>
            <div className={styles.bellIcon}><Bell notificationCount={taskToday} /></div>
        </div>
        <div className={styles.day}>{day}</div>
        <button className={styles.task_button} onClick={hendleTasksPopup}>task</button>

      </div>
    </div>
  );
}
