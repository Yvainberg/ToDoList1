import { useContext } from "react";
import DataContext from "../../context/dataContext";
import styles from "./style.module.css";
import Popup from 'reactjs-popup';


function PopupManagement() {

    const { isOpen, setIsOpen, popupComponent, setpopupComponent } = useContext(DataContext);
    const handleClosePopup = () => {
        setpopupComponent(null);
        setIsOpen(false);
    };

    return (
        <div>
            <Popup
                open={isOpen}
                onClose={() => setIsOpen(false)}
                modal
                closeOnDocumentClick
                contentStyle={{ width: "auto", height: "auto", backgroundColor: 'white', padding: '20px' }}
                overlayStyle={{ background:'rgba(0, 0, 0, 0.6)'}}
                
            >
                <div>
                    {popupComponent}

                   {isOpen&&<button className="close_button" onClick={() => handleClosePopup()}>
                   cancel
                    </button>} 
                </div>
            </Popup>
        </div>
    )

}

export default PopupManagement;
