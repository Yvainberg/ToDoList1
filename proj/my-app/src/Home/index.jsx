
import ListCreationForm from "../pages/ListCreationForm";
import GetListFromServer from "../pages/GetListFromServer";
import UpdateContent from "../pages/UpdateContent";
import { useEffect, useState } from 'react';
import styles from "./style.module.css";
import { useContext } from 'react';
import DataContext from "../context/dataContext";
import PopupManagement from "../compotes/popup";

export default function Home() {
    const { setIsOpen, setpopupComponent, stack, setLoading } = useContext(DataContext);


    useEffect(() => {
        console.log("stack home", stack);
        if (stack) {
            setpopupComponent(<UpdateContent stack={stack} />)
            setIsOpen(true);
        }
    }, [stack]);
    return (
        <div >
            <div className={styles.list}>
                <GetListFromServer />
            </div>
            <PopupManagement />
        </div>
    );
}


