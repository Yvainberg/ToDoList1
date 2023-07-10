import SyncLoader from "react-spinners/SyncLoader";

export default function Spinner() {

    const cssSpinner = {
        position: "fixed",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        zIndex: "9999",
    };
    return (
        <div className="sweet-loading">
            <SyncLoader
                color="#112ad0"
                cssOverride={cssSpinner}
                loading
                margin={6}
                size={15}
            />
        </div>
    );
}